from . import api as api

class Hook:
    
    def __init__(self, name, type):
        
        #types: int, str, arr, obj
        self.type = type
        
        if self.type == "int":
            self.value = 0
        elif self.type == "str":
            self.value = ""
        elif self.type == "arr":
            self.value = []
        elif self.type == "obj":
            self.value = {}
        else:
            self.type == "str"
            self.value = ""
        
        self.data = {}
        
    
    def get_type(self):
        return self.type

    def set_type(self, type):
        self.type = type
    
    def on_get(self):
        pass
    
    def get(self):
        """
        returns current value
        """
        on_get()
        return self.value
    
    def on_set(self):
        pass
    
    def set(self, value):
        """
        sets current value to value param
        """
        self.data = api.get_data_obj()
        self.data[self.name] = value
        self.value = value
        api.set_data_obj(self.data)
        on_set()
    
    def listen(self, data):
        if data[self.name] != self.value:
            self.value = data[self.name]
        