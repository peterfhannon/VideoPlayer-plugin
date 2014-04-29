cordova.define("com.unit11apps.videoplayer.VideoPlayer", function(require, exports, module) {

var exec = require("cordova/exec");

var VideoPlayer = {
    play: function(url) {
        exec(null, null, "VideoPlayer", "playVideo", [url]);
    }
};

module.exports = VideoPlayer;

});
