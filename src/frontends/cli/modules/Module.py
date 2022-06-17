from . import Setting

class Module:
    """
    module base:
    name, type, debug=False
    
    if it ain't broke, don't fix it.
    """
    
    def __init__(self, name, type, debug=False):
        self.name = name
        self.type = type
        self.debug = debug
        self.settings = []
        
        self.state = False
    
    def debug_msg(self, msg):
        if self.debug:
            print("DEBUG: " + msg)
    
    def on_enable(self):
        return 0
    
    def on_disable(self):
        return 0
    
    def enable(self):
        self.state = True
        self.debug_msg("%s enabled" % self.name)
        self.on_enable()
    
    def disable(self):
        self.state = False
        self.debug_msg("%s disabled" % self.name)
        self.on_disable()
    
    def toggle(self):
        self.state = not self.state
        if self.state:
            self.enable()
        else:
            self.disable()
    
    def on_tick(self):
        return 0
    
    def tick(self):
        if self.state:
            for s in self.settings:
                obj = s.get_object()
                if obj["type"] == "int":
                    if obj["value"] < obj["min"]:
                        obj["value"] = obj["min"]
                        self.debug_msg("value can't be below min, fixing (%s : %s)" % (self.get_name(), obj["name"]))
                    elif obj["value"] > obj["max"]:
                        obj["value"] = obj["max"]
                        self.debug_msg("value can't be above max, fixing (%s : %s)" % (self.get_name(), obj["name"]))
                        
                    if obj["max"] == obj["min"]:
                        obj["max"] += obj["increment"]
                        self.debug_msg("max can't == min, fixing (%s : %s)" % (self.get_name(), obj["name"]))
                        
            self.on_tick()
            self.debug_msg("%s ticked" % self.name)
        
    def get_state(self):
        return self.state
    
    def get_name(self):
        return self.name

    def get_type(self):
        return self.type
    
    def set_type(self, value):
        self.type = value
    
    def add_setting(self, setting):
        setting = Setting.Setting(self, setting)
        self.settings.append(setting)

    def rem_setting(self, setting_name):
        """
        give it a setting name, it removes the setting.
        """
        for s in self.settings:
            if s.get_name == setting_name:
                self.settings.remove(s)

    def get_settings(self):
        return self.settings