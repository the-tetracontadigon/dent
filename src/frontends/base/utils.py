import os
import __main__

class Module:
    
    def debug(self, message):
        if self.debug_setting:
            print("[DEBUG]: " + message)

    def __init__(self, name, category, ui_fields=[["toggle", "Enabled"]], debug_setting=False):
        self.debug_setting = debug_setting
        self.name = str(name)
        self.category = category
        self.ui_fields = ui_fields
        self.enabled = False
        if debug_setting:
            print("[DEBUG]: New module instantiated: " + self.name + " ("+ str(self.category) + ") UI:" + str(self.ui_fields))
        __main__.MODULES.append(self)

    def on_enable(self):
        pass
        
    def on_disable(self):
        pass
    
    def tick(self):
        pass
    
    def toggle(self):
        self.enabled = not self.enabled
        if self.enabled:
            on_enable()
        else:
            on_disable()
        self.debug("Toggled %s. New state is: %s" % (self.name, self.enabled))
    
    def enable(self):
        self.enabled = True
        on_enable()
        self.debug("Enabled %s" % (self.name))
    
    def disable(self):
        self.enabled = False
        self.on_disable()
        self.debug("Disabled %s" % (self.name))
    
    def get_name(self):
        return self.name
    
    def set_name(self, name):
        self.debug("Set name of %s to %s" % (self.name, name))
        self.name = name
    
    def get_category(self):
        return self.category
    
    def set_category(self, category):
        self.debug("Set category of %s to %s" % (self.name, category))
        self.category = category
        
    def get_ui_fields(self):
        return self.ui_fields
    
    def set_ui_fields(self, ui_fields):
        self.debug("Set ui_fields of %s to %s" % (self.name, ui_fields))
        self.ui_fields = ui_fields
