WinWaitActive("Windows Security");To pass user name and password
Sleep(1000)
ControlFocus("Windows Security","","Edit1")
ControlSetText("Windows Security","","Edit1","mesmarjo")
Sleep(1000)
ControlFocus("Windows Security","","Edit2")
ControlSetText("Windows Security","","Edit2","7Mp}l77V")
Sleep(1000)
ControlClick("Windows Security", "", "Button2")