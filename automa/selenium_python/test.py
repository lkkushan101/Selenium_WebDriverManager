import unittest
from selenium import webdriver
from selenium.webdriver.common.by import By


class SampleTest(unittest.TestCase):

    def setUp(self):
        self.driver = webdriver.Chrome()

    def pypi_test(self):
        self.driver.get("http://www.google.lk")
        self.driver.find_element(By.ID, "lst-ib").send_keys("Selenium")
        self.driver.find_element(By.ID, "hplogo").click()
        self.driver.find_element(By.NAME, "btnK").click()

    def tearDown(self):
        self.driver.quit()

