from pywinauto import Application
from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://yuilibrary.com/yui/docs/uploader/uploader-multiple.html")
elem = driver.find_element_by_xpath("//button[@class='yui3-button']")
elem.click()
time.sleep(3)
#wait for 3 seconds for the open dialog to appear
#pywinauto will do open dialog automation
app = Application().connect( title_re="Open")
app.Open.Edit.SetText("DY4daMhWAAAPgJ7.jpg")
time.sleep(3)
#will close the Open dialog
app.Open.Button.click()
