import pickledb
from utils import debug, error

class Query:

    def __init__(self, path):
        self.db = pickledb.load(path, True)
    
    def get_hook_value(self, name):
        """ Returns value from the database given a name """
        debug("DB: GET " + str(name))
        return self.db.get(name)

    def set_hook_value(self, name, value):
        """ Update's a hook's value in the database given its name and new value """
        self.db.set(name, str(value))
        debug("DB: SET " + name + ", " + str(value))
    
    def delete_hook(self, name):
        """ Deletes hook data given a name """
        self.db.rem(str(name))
        debug("DB: DEL " + name)