import json
from flask import Flask, jsonify

app = Flask(__name__)

data = {
    "backend": "base"
}

@app.route("/save")
def save():
    try:
        with open('data.json', 'w', encoding='utf-8') as f:
            json.dump(data, f, ensure_ascii=False, indent=4)
        return data
    except:
        return "Couldn't save data..."

@app.route("/append/<obj>")
def add_data(obj):
    """
    add data as json: {key: value}
    """
    try:
        j_data = json.loads(obj)
        data[next(iter(j_data))] = j_data[next(iter(j_data))]
        print(obj)
        save()
        return data
    except:
        print("Can't append %s to data" % str(obj))
    

@app.route("/remove/<key>")
def rem_data(key):
    key = key.replace('"',"")
    
    if key in data:
        del data[key]
    else:
        print("%s not in data" % str(key))
    return data

@app.route("/<key>")
def get_data(key):
    """
    get value of a key from data 
    """
    key = key.replace('"', "")
    
    try:
        return data[key]
    except:
        print("Can't get %s from data" % str(key))

@app.route("/")
def get_data_obj():
    return data

@app.route("/<obj>")
def set_data_obj(obj):
    data = json.loads(obj)
    print(data)
    save()
    return data

app.run()