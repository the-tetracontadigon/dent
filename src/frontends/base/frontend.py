import os
import utils
import time
import modules.Test

MODULES = []

test_module = modules.Test.Test()

shutdown = False
#main loop
while not shutdown:
    for m in MODULES:
        m.toggle()
    
    time.sleep(1)