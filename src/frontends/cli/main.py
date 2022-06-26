from modules import Example, Module, Setting
import time
import query
import os

VERSION = "0.0.1"

q = query.Query()

MODULES = []

running = False

# whenever you add a module, instantiate it here
def module_setup():
    MODULES.append(Example.Example())
    
# TODO: threading!
def tick():
    for module in MODULES:
        if module.get_state():
            module.tick()
        
def start():
    print("Client starting...")
    running = True
    while running:
        tick()
        time.sleep(0.2)
    
def edit_setting(s):
    obj = s.get_object()
    print("Editing %s..." % obj["name"])
    print("\nChoose a field in the setting:")

    # as a wise man once said:
    #
    #   screw regex, eww
    #
    for i in str(obj).replace("{", "").replace("}", "").replace("'", "").split(","):
        if "name:" not in i:
            print("    " + i)
    
    field = input("")
    if field in obj.keys():
        print("Current %s is " % field + str(obj[field]))
        value = input("new %s: " % field)
        obj[field] = value
        
        print("submitting setting change...")
        for m in MODULES:
            if s in m.get_settings():
                s.set_object(obj)
        print("setting change submitted.")


def module_settings():
    print("\n")
    print("choose a module:")
    print()
    for m in MODULES:
        print(m.get_name().lower())
    selected_module = input("\n").lower()
    for m in MODULES:
        if selected_module in m.get_name().lower():
            print()
            print("choose a setting:")
            print()
            for s in m.get_settings():
                obj = s.get_object()
                print(obj["name"] + " ("+ obj["type"] +")")
                
                for i in str(obj).replace("{", "").replace("}", "").replace("'", "").split(","):
                    if "name:" not in i:
                        print("    " + i)
                                
                print() 
            selected_setting = input("").lower()
            print()
            for s in m.get_settings():
                if selected_setting in s.get_object()["name"].lower():
                    edit_setting(s)
                    menu()
    
    
    
def global_settings():
    print("global settings")
    
def kill_client():
    print("killing client...")
    print("deleting database...")
    exit()
     
     
def menu_press():
    k = input("\n            ").lower()
    
    if k =="s":
        start()
    elif k == "k":
        kill_client()
    elif k == "m":
        module_settings()
    elif k == "g":
        global_settings()
    else:
        exit()

def menu():
    print("""
            dent
            CLI FRONTEND: v%s
        """ % (str(VERSION)))

    print("            [s] start client")
    print("            [k] kill client")
    print("            [m] module settings")
    print("            [g] global settings")
    print("            [anything] hide cli")
    menu_press()

module_setup()
menu()