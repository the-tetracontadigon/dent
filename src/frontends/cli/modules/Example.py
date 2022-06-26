from modules import Module
import sys, os
sys.path.append("../")
import query
from utils import debug, error

class Example(Module.Module):
    
    def __init__(self):
        super(Example, self).__init__("Example", 1, debug=True)
        self.add_setting({
            "name": "test",
            "description": "This is a description",
            "type": "int",
            "min": 0,
            "max": 10,
            "interval": 1,
            "value": 2
        })
        

        self.q = query.Query()
        self.enable()
        self.tick_counter = 0
    
    def on_tick(self):
        sprint = self.q.get_hook_value("Sprint")
        print(sprint)

        if not "front" in sprint and str(sprint).removesuffix("|front") == "false":
            self.q.set_hook_value("Sprint", "true|front")

    def on_enable(self):
        print("i got enabled :)")
    
    def on_disable(self):
        print("i got disabled :(")