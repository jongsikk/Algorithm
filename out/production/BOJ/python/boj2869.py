day, night, height = map(int, input().split())

#day만큼 올라가고 night만큼 내려감 height만큼 올라가야함
result = 1
sum = 0
one = day - night
if day >= height:
    print(result)
while True:
    sum = sum + one + day
    if sum >= height:
        print(result)
        break
    else:
        result += 1
