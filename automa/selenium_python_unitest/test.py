import unittest
from selenium import webdriver
from selenium.webdriver.common.keys import Keys

class PythonOrgSearch(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()

    def test_search_in_python_org(self):
        driver = self.driver
        driver.get("http://www.google.lk")
        self.assertIn("Google", driver.title)
        elemntSearchInput = driver.find_element_by_id("lst-ib")
        elemntSearchInput.send_keys("Selenium")
        elemntSearchButton = driver.find_element_by_name("btnK")
        elemntSearchButton.click()
        selenium_link = driver.find_element_by_link_text("Selenium - Web Browser Automation")
        selenium_link.click();
        self.assertIn("Selenium - Web Browser Automation", driver.title)

    def tearDown(self):
        self.driver.close()

if __name__ == "__main__":
    unittest.main()