set wsc = CreateObject("WScript.Shell")
WSH.Echo "Started"
Do
WScript.Sleep(60*1000)
wsc.SendKeys("{SCROLLLOCK 2}")
Loop
