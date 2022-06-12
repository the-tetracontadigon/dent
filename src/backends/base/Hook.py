from utils import debug, error

class Hook:
    
    def __init__(self, name, type):
        
        self.name = name

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
        
        # self.data = {}
        
    def get_name(self):
        return self.name

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
        self.on_get()
        debug(self.name + " GET: " + str(self.value))
        return self.value
    
    def on_set(self):
        pass
    
    def set(self, value):
        """
        sets current value to value param
        """
        import fast as api
        # self.data = api.get_data_obj()
        # self.data[self.name] = value
        # self.value = value
        # api.set_data_obj(self.data)

        self.value = value
        self.on_set()
        debug(self.name + " SET: " + str(self.value))