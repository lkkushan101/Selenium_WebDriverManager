from selenium import webdriver
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
driver.get("http://www.google.lk")
assert "Google" in driver.title

search_input = driver.find_element_by_id("lst-ib")
search_input.send_keys("Selenium")

search_button = driver.find_element_by_name("btnK")
search_button.click()

selenium_link = driver.find_element_by_link_text("Selenium - Web Browser Automation")
selenium_link.click();

assert "Selenium - Web Browser Automation" in driver.title
driver.close()