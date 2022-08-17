N, X = map(int, input().split())

n = list(map(int, input().split()))

for i in range(len(n)):
    if X > n[i]:
        print(n[i], end=" ")