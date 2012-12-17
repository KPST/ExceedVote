var day;
var hour;
var min;
var sec;
var dd;
function CreateTimer(dayID,hourID,minID,secID, Time) {
        day = document.getElementById(dayID);
        hour = document.getElementById(hourID);
        min = document.getElementById(minID);
        sec = document.getElementById(secID);
        dd = Time;
        UpdateTimer();
        //window.setTimeout("UpdateTimer()", 1000);
}

function UpdateTimer(){
	dd--;
	var Seconds = dd;
	
    var Days = Math.floor(Seconds / 86400);
    Seconds -= Days * 86400;

    var Hours = Math.floor(Seconds / 3600);
    Seconds -= Hours * (3600);

    var Minutes = Math.floor(Seconds / 60);
    Seconds -= Minutes * (60);
    
    if(dd<=0){
    	document.getElementById('dday').innerHTML = 0;
        document.getElementById('dhour').innerHTML = 0;
        document.getElementById('dmin').innerHTML = 0;
        document.getElementById('dsec').innerHTML = 0;
    	return;
    }
    else{
    	document.getElementById('dday').innerHTML=Days;
    	document.getElementById('dhour').innerHTML=Hours;
    	document.getElementById('dmin').innerHTML=Minutes;
    	document.getElementById('dsec').innerHTML=Seconds;
    }    
	window.setTimeout("UpdateTimer()",1000);
}
