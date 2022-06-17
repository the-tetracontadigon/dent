from modules import Module
import sys
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
        

        self.q = query.Query("../../backends/base/hooks.db")
        self.enable()
    
    def on_tick(self):
        print("hi")
        print(self.q.get_hook_value("pos"))
        self.q = query.Query("../../backends/base/hooks.db")

    def on_enable(self):
        print("i got enabled :)")
    
    def on_disable(self):
        print("i got disabled :(")