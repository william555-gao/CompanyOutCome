function checkSign() {
    try {
        InfoSecNetSign1.getVersion();
    } catch (e) {
        return "nosign";
    }
}

function dowloadSign() {
    window.location.href = "TravelSkyUSBKeyDriver.zip";
}

function buttonAttachedSign_onclick(str) {
    InfoSecNetSign1.NSSetPlainText(str);
    var signedData = "";
    var errorMessage = "";
    if (InfoSecNetSign1.errorNum != 0) {
        //return InfoSecNetSign1.errorNum + "\n" + InfoSecNetSign1.errMsg;
        return "error:" + InfoSecNetSign1.errorNum;
    } else {
        signedData = InfoSecNetSign1.NSAttachedSign("C=CN, O=TravelSky|C=CN, O=CA");
    }
    if (InfoSecNetSign1.errorNum != 0) {
        //return InfoSecNetSign1.errorNum + "\n" + InfoSecNetSign1.errMsg + "\n(" + InfoSecNetSign1.errorCode + ")";
        return "error:" + InfoSecNetSign1.errorNum;
    } else {
        //alert(InfoSecNetSign1.NSGetSignerCertInfo(1));
        return signedData;
    }
}