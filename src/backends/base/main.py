import query, Hook, hook_manager
from hooks.Pos import Pos

"""
DENT CLIENT v0.0.0
"""

#setup
q = query.Query()

#instantiate hooks
HOOKS = []

HOOKS.append(Pos())

hm = hook_manager.HookManager(HOOKS)

