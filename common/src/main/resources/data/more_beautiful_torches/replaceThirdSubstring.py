import os

def replace_third_occurrence(text, old, new):
    """Replace the third occurrence of old with new in text."""
    parts = text.split(old, 3)
    if len(parts) > 3:
        return old.join(parts[:3]) + new + parts[3]
    return text

def replace_fourth_occurrence(text, old, new):
    """Replace the third occurrence of old with new in text."""
    parts = text.split(old, 4)
    if len(parts) > 4:
        return old.join(parts[:4]) + new + parts[4]
    return text

def process_file(filepath):
    """Read a file, replace the third occurrence of 'item' with 'id', and save the changes."""
    with open(filepath, 'r', encoding='utf-8') as file:
        content = file.read()

    if "soul_torch" in filepath:
        updated_content = replace_fourth_occurrence(content, 'item', 'id')
    elif "redstone" in filepath:
        updated_content = replace_third_occurrence(content, 'item', 'id')
    else:
        updated_content = replace_fourth_occurrence(content, 'item', 'id')

    with open(filepath, 'w', encoding='utf-8') as file:
        file.write(updated_content)

def process_folder(folder_path):
    """Iterate over all files in the specified folder and process each file."""
    for filename in os.listdir(folder_path):
        filepath = os.path.join(folder_path, filename)
        if os.path.isfile(filepath):
            process_file(filepath)

# Set the folder path
folder_path = 'recipes'

# Process the folder
process_folder(folder_path)
