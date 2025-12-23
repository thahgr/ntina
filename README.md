# Ντίνα (Ntina)

<img src="app/src/main/ic_launcher-playstore.png" alt="App Icon" width="128">

An Android application designed to simplify the process of sending SMS messages required by the Greek state during the COVID-19 quarantine period. The app provided a quick and direct way for citizens to request permission to leave their homes by sending formatted SMS messages to the official government numbers.

## Overview

During the COVID-19 pandemic, the Greek government implemented a quarantine system that required citizens to send SMS messages with specific codes to request permission for leaving their homes. This app streamlined that process by:

- Storing user's personal information (name and address) in settings
- Providing quick-access buttons for different movement reasons
- Automatically formatting and sending SMS messages to the correct government numbers

## Features

- **Quick SMS Generation**: One-tap SMS creation with pre-filled personal information
- **Multiple Movement Reasons**: Support for 6 different movement codes plus shopping:
  1. Movement for health reasons
  2. Going to a supply store
  3. Going to public service and bank
  4. Movement to provide assistance
  5. Going to a funeral
  6. Physical exercise
  7. Movement to a commercial store (shopping)
- **Settings Management**: Store name and address for quick reuse

## SMS Format

The app sends SMS messages in the following formats:

- **For codes 1-6**: `[code] [name] [address]` to number **13033**
- **For shopping**: `[name] [address]` to number **13032**

## How It Works

1. **Initial Setup**: Users configure their name and address in the app settings
2. **Select Reason**: Users tap on the appropriate reason button from the main screen
3. **Confirmation**: A confirmation dialog appears before sending
4. **SMS Sending**: The app opens the default SMS app with the pre-filled message and recipient number

