# epoch-realtime-data-stream
This is a real time data streaming application using redis pubsub model and node.js and epoch.
The server side data is published to redis using spring data redis publisher and is consumed by node.js subscriber which is then used by 
epoch.js to diplay real time charts.
