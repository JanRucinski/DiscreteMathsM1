import heapq

def dijkstra(graph, start):
    # Initialize distances with infinity for all nodes except the start node
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0

    # Priority queue to store nodes to visit
    queue = [(0, start)]

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        # Skip node if we've already found a shorter path
        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight
            # If this path is shorter, update the distance
            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(queue, (distance, neighbor))

    return distances

def bellman_ford(graph, start):
    # Initialize distances with infinity for all nodes except the start node
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0

    # Relax edges repeatedly
    for _ in range(len(graph) - 1):
        for node in graph:
            for neighbor, weight in graph[node].items():
                if distances[node] + weight < distances[neighbor]:
                    distances[neighbor] = distances[node] + weight

    # Check for negative cycles
    for node in graph:
        for neighbor, weight in graph[node].items():
            if distances[node] + weight < distances[neighbor]:
                raise ValueError("Graph contains a negative-weight cycle")

    return distances

import time
import random

# Function to generate a random graph
def generate_random_graph(nodes, edges):
    graph = {i: {} for i in range(nodes)}
    for _ in range(edges):
        node1 = random.randint(0, nodes - 1)
        node2 = random.randint(0, nodes - 1)
        weight = random.randint(1, 10)  # Random weight between 1 and 10
        graph[node1][node2] = weight
    return graph

# Test the algorithms
def test_algorithms():
    # Test different graph sizes
    for size in [10, 50, 100, 500, 1000]:
        graph = generate_random_graph(size, size * 2)  # Roughly 2 * number of nodes for edges
        start_node = random.randint(0, size - 1)
        
        # Measure Dijkstra's execution time
        start_time = time.time()
        dijkstra(graph, start_node)
        dijkstra_time = (time.time() - start_time) * 1000  # Convert to milliseconds
        
        # Measure Bellman-Ford's execution time
        start_time = time.time()
        bellman_ford(graph, start_node)
        bellman_ford_time = (time.time() - start_time) * 1000  # Convert to milliseconds
        
        print(f"Graph Size: {size}, Dijkstra Time: {dijkstra_time:.2f} ms, Bellman-Ford Time: {bellman_ford_time:.2f} ms")

# Run the test
test_algorithms()
