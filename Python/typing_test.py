txt = open('Python/words.txt')
words =  {}

for line in txt:
    if line not in words:
        words[line] = 0
    else:
        print(line)
