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
        # self.tick_counter += 1
        # pos = self.q.get_hook_value("Pos")
        # pos = pos.split("|")[0]
        # pos = str(pos).replace("(", "")
        # pos = pos.replace(")", "")
        # pos = pos.replace("[", "")
        # pos = pos.replace("]", "")
        # pos = pos.split(",")

        # x = float(pos[0])
        # y = float(pos[1])
        # z = float(pos[2])
        
        # x = 0
        # if self.tick_counter % 10 == 0:
        #     y += 1
        # z = 0

        # self.q.set_hook_value("Pos", str([x, y, z]).replace("[", "(").replace("]", ")") + "|front")
        self.q.set_hook_value("Pos", "(0,0,0)|front")

    def on_enable(self):
        print("i got enabled :)")
    
    def on_disable(self):
        print("i got disabled :(")