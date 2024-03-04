import math

n = int(input())

for i in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    dist = math.sqrt((x2-x1)**2 + (y2-y1)**2)
    if ((x1 == x2) and (y1 == y2)):
        if(r1 == r2):
            print(-1)
        else:
            print(0)
    #외접 / 내접
    elif(r1 + r2 == dist or dist == abs(r2 - r1) or dist == abs(r1 - r2)):
        print(1)
    #0개일때
    elif(abs(r1 - r2) < dist < r1 + r2):
        print(2)
    else:
        print(0)