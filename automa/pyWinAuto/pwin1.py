from pywinauto import application
import time
import pywinauto
from pywinauto.findbestmatch import find_best_match

appl = application.Application()
appl.Start("Notepad.exe")

appl.Notepad.edit.TypeKeys("This is automation")
appl.Notepad.MenuSelect("File->Save")
appl.SaveAs.edit.SetText("kushanmeetup.txt")
appl.SaveAs.Save.click()
appl.Notepad.Close()