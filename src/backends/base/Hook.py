from utils import debug, error

class Hook:
    
    def __init__(self, name, type):
        
        self.name = name

        self.value = ""
        
    def get_name(self):
        return self.name
    
    def on_get(self):
        pass
    
    def get(self):
        """
        returns current value
        """
        self.on_get()
        debug(self.name + " GET: " + str(self.value))
        return self.value
    
    def on_set(self):
        pass
    
    def set(self, value):
        """
        sets current value to value param
        """
        self.value = value
        self.on_set()
        debug(self.name + " SET: " + str(self.value))