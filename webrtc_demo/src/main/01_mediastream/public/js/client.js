'use strict'

// 获取 HTML 页面中的 video 标签
var videoplay = document.querySelector('video#player');

// 播放视频流
function gotMediaStream(stream){

    var videoTrack = stream.getVideoTracks()[0];

    window.stream = stream;
    videoplay.srcObject = stream;
}

function handleError(err){
    console.log('getUserMedia error:', err);
}

function start() {

    if(!navigator.mediaDevices ||
       !navigator.mediaDevices.getUserMedia){

        console.log('getUserMedia is not supported!');
        return;

    }else{

        // 对采集的数据做一些限制
        var constraints = {
            video : {
                width: 724,
                height: 480,
                frameRate:15,
                facingMode: 'enviroment'
		//,
                //deviceId : deviceId ? {exact:deviceId} : undefined 
            }, 
            audio : false 
        }

        // 采集音视频数据流
        navigator.mediaDevices.getUserMedia(constraints)
            .then(gotMediaStream)
            .catch(handleError);
    }
}

start();
