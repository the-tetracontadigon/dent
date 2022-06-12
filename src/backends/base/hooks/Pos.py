import sys
sys.path.append("../")
import Hook
import query

class Pos(Hook.Hook):
    
    def __init__(self):
        super(Pos, self).__init__("pos", "arr")

        self.q = query.Query()

        self.value = [1,1,1]
    
    def on_get(self):
        #get position somehow
        self.value[1] += 1
        return self.value

    def on_set(self):
        #set position somehow
        pass