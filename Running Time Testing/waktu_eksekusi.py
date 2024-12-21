import pandas as pd
import matplotlib.pyplot as plt

# Baca data dari file CSV
data = pd.read_csv('execution_times.csv')

# Plot grafik
plt.figure(figsize=(10, 6))
plt.plot(data['InputSize'], data['ExecutionTime'], marker='o')
plt.title('Running Time Analysis', fontsize=16)
plt.xlabel('Ukuran Papan (Input Size)', fontsize=14)
plt.ylabel('Waktu Eksekusi (ms)', fontsize=14)
plt.grid(True)
plt.savefig('running_time_plot.png')
plt.show()