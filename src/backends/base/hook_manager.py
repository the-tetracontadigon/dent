import Hook
from hooks import Pos
import query
import time
from utils import debug, error


class HookManager:
    """
    manages hooks
    """

    def __init__(self, hooks):
        self.hooks = hooks
        self.q = query.Query()

        shutdown = False
        
        init_start = time.time()
        #init hooks here
        for hook in hooks:
            self.q.set_hook_value(hook.get_name(), hook.get())
        init_end = time.time()
        debug("hooks initialized in db (%s seconds)" % str((init_end - init_start)))
        
        while not shutdown:
            try:
                self.tick(0.1)
            except:
                debug("Stopping...")
                exit()

    def get_hook(self, hook_name):
        for hook in self.hooks:
            if hook.get_name() == hook_name:
                return hook
    
    def tick(self, interval):
        for hook in self.hooks:
            self.q.set_hook_value(hook.get_name(), hook.get())
            time.sleep(interval)