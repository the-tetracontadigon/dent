debug = True

def debug(message):
    if debug:
        print("[DEBUG]: " + str(message))

def error(message):
    if debug:
        print("[ERROR]: " + str(message))