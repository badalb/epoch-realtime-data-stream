var http    = require('http')
,   express = require('express')
,   redis  = require('redis'),
app=express();

function ticker(req,res) {
 req.socket.setTimeout(Infinity);
 
  var subscriber = redis.createClient();
	
  subscriber.subscribe("test");
	
  // When we receive a message from the redis connection
  subscriber.on("message", function(channel, message) {
		res.json(message);
  });
	
  //send headers for event-stream connection
  res.writeHead(200, {
    'Content-Type': 'text/event-stream',
    'Cache-Control': 'no-cache',
    'Connection': 'keep-alive'
  });

  res.json = function(obj) { res.write("data: "+obj+"\n\n"); }
  res.json(JSON.stringify({}));
 
  // The 'close' event is fired when a user closes their browser window.
  req.on("close", function() {
    subscriber.unsubscribe();
    subscriber.quit();
  });
}

// app.get('/', function(req, res) {
// // res.send(__dirname + '/public/index.html');
// res.send(__dirname + '/public/index.html');
// });


app.use(express.static(__dirname + '/public'));

app.use(function(req,res) {
        if(req.url == '/eventCounters') {
            ticker(req,res);
        }
})

console.log(__dirname + '/public');
app.listen(9000, '0.0.0.0');