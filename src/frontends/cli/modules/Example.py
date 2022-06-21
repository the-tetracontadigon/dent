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
    
    def on_tick(self):
        print("hi")
        pos = self.q.get_hook_value("Pos")
        pos = str(pos).replace("[", "")
        pos = pos.replace("]", "")
        pos = pos.split(",")

        print(pos[1])

        x = float(pos[0])
        y = float(pos[1])
        z = float(pos[2])
        
        y += 0.1

        self.q.set_hook_value("pos", [x, y, z])

        self.q = query.Query()

    def on_enable(self):
        print("i got enabled :)")
    
    def on_disable(self):
        print("i got disabled :(")