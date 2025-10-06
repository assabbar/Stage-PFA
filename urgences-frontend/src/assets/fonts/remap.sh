#!/bin/bash
# remap all files from cdn to local
# Original CSS file with remote URLs
CSS_FILE="lato"

# Output (or overwrite original)
OUTPUT_FILE="lato-local.css"

# Base path to use in Angular project (relative to `src`)
LOCAL_PATH="/assets/fonts"

# Create output file
cp "$CSS_FILE" "$OUTPUT_FILE"

# Extract unique font URLs and process each
grep -oP "url\('\K[^']+" "$CSS_FILE" | sort -u | while read -r url; do
    # Extract the filename from the URL
    filename=$(basename "$url")

    # Replace remote URL with local path
    sed -i "s|url('$url')|url('$LOCAL_PATH/$filename')|g" "$OUTPUT_FILE"
done

echo "Updated CSS written to $OUTPUT_FILE"

