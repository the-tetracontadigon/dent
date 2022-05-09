class Setting:
    """
    Setting base class
    accepts parent module and object containing setting settings
    """
    
    def __init__(self, module, object):
        self.module = module
        self.object = object
        self.parse_obj(self.object)
    
    def parse_obj(self, obj):
        print(obj)
        self.name = obj["name"]
        self.type = obj["type"]
        self.description = obj["description"]
        
        #slider
        if self.type == "int":
            self.min = obj["min"]
            self.max = obj["max"]
            self.interval = obj["interval"]
            self.value = obj["value"]
        elif self.type == "bool":
            self.toggle = obj["value"]
        elif self.type == "str":
            self.value = obj["value"]
        
    def get_object(self):
        return self.object

    def set_object(self, obj):
        self.object = obj
        
    def get_value(self):
        try:
            return self.value
        except:
            module.debug_msg("Cannot get value from %s" + self.object["name"])
    
    def set_value(self, value):
        try:
            self.value = value
        except:
            module.debug_msg("Cannot set value of %s from %s" % (self.object["name"], self.module.get_name()))