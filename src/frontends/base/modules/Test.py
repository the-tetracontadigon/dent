import os, sys
sys.path.append(os.path.dirname(os.path.dirname(os.path.abspath(__file__))))
import __main__
import utils

class Test(utils.Module):
    
    def __init__(self):
        super(Test, self).__init__(self, "Test", 0, debug_setting=True)
    
    def on_enable(self):
        print("Test enabled.")
        return super().on_enable()
    
    def on_disable(self):
        print("Test disabled.")
        return super().on_disable()

    def tick(self):
        print("Hi")
        return super().tick()