import pandas as pd

# Load the data
df = pd.read_csv('grades_mapping_complete.csv')  # Change 'path_to_your_file.csv' to your file's path

# Generate the Clojure string for each row
clojure_strings = []
for index, row in df.iterrows():
    clojure_row = f'"{row["Grade"]}" {{'
    clojure_row += ', '.join([f':{col.replace("/", "-")} "{val}"' for col, val in row.items() if col != "Grade"])
    clojure_row += '}'
    clojure_strings.append(clojure_row)

# Combine all rows into a single Clojure data structure string
clojure_data = "(def sport-grades-mapping (array-map \n" + "\n                                     ".join(clojure_strings) + "\n))"

# Save or print the Clojure data
print(clojure_data)

# Optionally, you can save this to a text file:
with open('output.cljs', 'w') as file:
    file.write(clojure_data)
