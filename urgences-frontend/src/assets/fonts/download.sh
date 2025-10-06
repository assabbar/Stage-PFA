#!/bin/bash

# Save the CSS content to a file (or pipe it into this script)
CSS_FILE="lato"

# Extract all unique font URLs from the CSS file
grep -oP "url\('\K[^']+" "$CSS_FILE" | sort -u > font_urls.txt

# Create output directory
mkdir -p downloaded_fonts

# Download each font file
while read -r url; do
    echo "Downloading: $url"
    curl -L -O --output-dir downloaded_fonts "$url"
done < font_urls.txt

echo "All fonts downloaded to 'downloaded_fonts/'"

