WinWaitActive("Windows Security");To pass user name and password
Sleep(1000)
ControlFocus("Windows Security","","Edit1")
ControlSetText("Windows Security","","Edit1","acharan")
Sleep(1000)
ControlFocus("Windows Security","","Edit2")
ControlSetText("Windows Security","","Edit2","Casio@207")
Sleep(1000)
ControlClick("Windows Security", "", "Button2")

