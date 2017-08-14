package main
import (
	"fmt"
	"os"
	"bufio"
)

func main() {
	if (len(os.Args) >= 2) {
		file, err := os.Open(os.Args[1])
		if (err != nil) {
			fmt.Println(err)
		} else {
			scanner := bufio.NewScanner(file)
			var count int64
			for scanner.Scan() {
				scanner.Text()
				count++
			}
			fmt.Println(count)
		}
	}
}
