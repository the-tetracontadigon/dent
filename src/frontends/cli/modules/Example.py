from modules import Module

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
    
    def on_tick(self):
        print("hi")
    
    def on_enable(self):
        print("i got enabled :)")
    
    def on_disable(self):
        print("i got disabled :(")