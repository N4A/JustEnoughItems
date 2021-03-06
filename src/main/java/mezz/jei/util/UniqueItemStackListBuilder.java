package mezz.jei.util;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mezz.jei.Internal;
import net.minecraft.item.ItemStack;

public class UniqueItemStackListBuilder {
	private final List<ItemStack> itemStacks = new ArrayList<ItemStack>();
	private final Set<String> itemStackUids = new HashSet<String>();

	public void add(@Nonnull ItemStack itemStack) {
		String uid = Internal.getStackHelper().getUniqueIdentifierForStack(itemStack, StackHelper.UidMode.NORMAL);
		if (!itemStackUids.contains(uid)) {
			itemStackUids.add(uid);
			itemStacks.add(itemStack);
		}
	}

	@Nonnull
	public List<ItemStack> build() {
		return itemStacks;
	}
}
