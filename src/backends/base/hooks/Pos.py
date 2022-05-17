from .. import Hook

class Pos(Hook.Hook):
    
    def __init__(self):
        super(Pos, self).__init__("Pos", "arr")
    
    def on_get(self):
        #get position somehow
        pass

    def on_set(self):
        #set position somehow
        pass