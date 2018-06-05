from pywinauto import application


appl = application.Application()
appl.Start("Notepad.exe")

appl.Notepad.edit.TypeKeys("This is automation")
appl.Notepad.MenuSelect("File->Save")
appl.SaveAs.edit.SetText("kushanmeetup.txt")
appl.SaveAs.Save.click()
appl.Notepad.Close()