<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="js/timer.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
</head>

<body>

<table id="table" border="0" cellpadding="0" cellspacing="0">
    <tr>
        <td align="center" colspan="6"><div class="numbers" id="count2" style="padding: 5px 0 0 0; "></div></td>
    </tr>
    <tr id="spacer1" height="30">
        <td align="center" ><div class="numbers" ></div></td>
        <td align="center" ><div class="numbers" id="dday"></div></td>
        <td align="center" ><div class="numbers" id="dhour"></div></td>
        <td align="center" ><div class="numbers" id="dmin"></div></td>
        <td align="center" ><div class="numbers" id="dsec"></div></td>
        <td align="center" ><div class="numbers" ></div></td>
    </tr>
    <tr id="spacer2" height="12">
        <td align="center" ><div class="title" ></div></td>
        <td align="center" ><div class="title" id="days">Days</div></td>
        <td align="center" ><div class="title" id="hours">Hours</div></td>
        <td align="center" ><div class="title" id="minutes">Minutes</div></td>
        <td align="center" ><div class="title" id="seconds">Seconds</div></td>
        <td align="center" ><div class="title" ></div></td>
    </tr>
</table>
<script type="text/javascript">window.onload = CreateTimer("dday","dhour","dmin","dsec", 3000000);</script>
</body>
</html>