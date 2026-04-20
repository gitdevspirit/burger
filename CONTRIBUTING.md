# Contributing to Burger 🍔

Thanks for your interest in contributing to Burger! This guide will help you get started.

## Getting Started

1. **Fork the repository** on GitHub
2. **Clone your fork** locally:
   ```bash
   git clone https://github.com/YOUR_USERNAME/burger.git
   cd burger
   ```
3. **Set up the development environment**:
   ```bash
   ./setup.sh  # Linux/Mac
   # or
   gradlew.bat wrapper  # Windows
   ```

## Development Workflow

### 1. Create a Branch

```bash
git checkout -b feature/my-new-feature
# or
git checkout -b fix/bug-description
```

### 2. Make Your Changes

- Follow the existing code style
- Add comments to complex code
- Update documentation if needed
- Test your changes thoroughly

### 3. Test Your Changes

```bash
./gradlew build
./gradlew runClient
```

### 4. Commit Your Changes

```bash
git add .
git commit -m "Add: Description of your changes"
```

**Commit message format:**
- `Add: New feature description`
- `Fix: Bug fix description`
- `Update: Changes to existing feature`
- `Docs: Documentation changes`
- `Refactor: Code refactoring`

### 5. Push and Create Pull Request

```bash
git push origin feature/my-new-feature
```

Then create a Pull Request on GitHub!

## Code Style Guidelines

### Java
- Use tabs for indentation
- Opening braces on the same line
- Descriptive variable names
- JavaDoc comments for public methods
- Keep methods small and focused

### Example:
```java
/**
 * Sends a message to the player
 * 
 * @param message the message to send
 */
public static void sendMessage(String message) {
	if (getPlayer() != null) {
		getPlayer().sendSystemMessage(Component.literal(message));
	}
}
```

### File Organization
```
com.burger/
├── features/      # Feature implementations
├── mixins/        # Mixin classes
├── config/        # Configuration
├── utils/         # Utility classes
└── BurgerMod.java # Main class
```

## Adding Features

### 1. Create Feature Class
```java
package com.burger.features;

import com.burger.BurgerMod;

public class MyFeature {
	
	public static void init() {
		BurgerMod.LOGGER.info("MyFeature initialized");
		// Your initialization code
	}
	
	// Feature methods here
}
```

### 2. Initialize in BurgerMod
```java
private void init() {
	BurgerConfig.load();
	WelcomeMessage.init();
	MyFeature.init(); // Add this
}
```

### 3. Add Config Options (if needed)
```java
// In BurgerConfig.java
public boolean myFeatureEnabled = true;
```

### 4. Add Tests (if applicable)
Test your feature in-game before submitting!

## Adding Mixins

### 1. Create Mixin Class
```java
package com.burger.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TargetClass.class)
public class TargetClassMixin {
	
	@Inject(method = "targetMethod", at = @At("HEAD"))
	private void onTargetMethod(CallbackInfo ci) {
		// Your code
	}
}
```

### 2. Register in burger.mixins.json
```json
{
  "client": [
    "TitleScreenMixin",
    "TargetClassMixin"
  ]
}
```

## Documentation

If your change affects user-facing features:

1. Update `FEATURES.md` with your feature
2. Add usage examples to `GETTING_STARTED.md` if needed
3. Update `CHANGELOG.md` with your changes
4. Add config options to documentation

## Pull Request Guidelines

### Before Submitting
- [ ] Code builds without errors
- [ ] Tested in-game
- [ ] No unnecessary files committed
- [ ] Code follows style guidelines
- [ ] Documentation updated (if needed)
- [ ] CHANGELOG.md updated

### PR Description Template
```markdown
## Description
Brief description of your changes

## Type of Change
- [ ] New feature
- [ ] Bug fix
- [ ] Documentation update
- [ ] Code refactoring

## Testing
How you tested this change

## Screenshots (if applicable)
Add screenshots here

## Related Issues
Fixes #issue_number
```

## Reporting Bugs

### Bug Report Template
```markdown
**Description**
Clear description of the bug

**To Reproduce**
1. Go to '...'
2. Click on '...'
3. See error

**Expected Behavior**
What should happen

**Screenshots**
If applicable

**Environment**
- Minecraft Version:
- Burger Version:
- Other Mods:
- Logs: (attach logs)
```

## Feature Requests

### Feature Request Template
```markdown
**Feature Description**
Clear description of the feature

**Use Case**
Why this feature is useful

**Example**
Example of how it would work

**Additional Context**
Any other information
```

## Code Review Process

1. **Automatic Checks**: GitHub Actions will build your PR
2. **Code Review**: Maintainers will review your code
3. **Feedback**: You may be asked to make changes
4. **Merge**: Once approved, your PR will be merged!

## Questions?

- Check existing issues
- Read the documentation
- Ask in discussions
- Join our community

## License

By contributing, you agree that your contributions will be licensed under the MIT License.

---

**Thank you for contributing to Burger!** 🍔

Every contribution, big or small, is appreciated!
