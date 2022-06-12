import pickledb
import os
from utils import debug

class Query:

    def __init__(self):
        self.db = pickledb.load('hooks.db', True)
    
    def get_hook_value(self, name):
        """ Returns value from the database given a name """
        debug("DB: GET " + str(name))
        return self.db.get(name)

    def set_hook_value(self, name, value):
        """ Update's a hook's value in the database given its name and new value """
        debug("DB: SET " + name + ", " + str(value))
        self.db.set(name, str(value))