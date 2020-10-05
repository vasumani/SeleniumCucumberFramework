WinWaitActive("Windows Security");To pass user name and password
Sleep(1000)
ControlFocus("Windows Security","","Edit1")
ControlSetText("Windows Security","","Edit1","mescalli")
Sleep(1000)
ControlFocus("Windows Security","","Edit2")
ControlSetText("Windows Security","","Edit2","4Zx~w8ic")
Sleep(1000)
ControlClick("Windows Security", "", "Button2")