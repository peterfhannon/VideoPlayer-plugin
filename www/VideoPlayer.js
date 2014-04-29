var exec = require("cordova/exec");

var VideoPlayer = {
    play: function(url) {
        exec(null, null, "VideoPlayer", "playVideo", [url]);
    }
};

module.exports = VideoPlayer;
